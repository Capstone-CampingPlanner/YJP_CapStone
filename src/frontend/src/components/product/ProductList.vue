<template>
  <h1>판매자들이 등록한 상품들의 리스트, 회원이 보게될 페이지</h1>
  <div>
    <ProductMain></ProductMain>
    <br>
    <table class="table table-striped">
      <thead>
      <tr>
        <th>메뉴번호</th>
        <th>메뉴명</th>
        <th>분류</th>
        <th>가격</th>
        <th>설명</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="product in list"
          :key="product.id"
          :item="product" @click="toDetail(product)" style="cursor:pointer;">
        <th scope="row">{{ product.menuid }}</th>
        <td>{{ product.menuname }}</td>
        <td>{{ product.kindid.kindname }}</td>
        <td>{{ product.price }}</td>
        <td>{{ product.ex }}</td>
      </tr>
      <!-- PathVariable 을 위해서는 router-link 작성 -->
<!--      <router-link :to="{name: 'productDetail', params: { menuid:product.menuid }}"></router-link>-->
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios'
import ProductMain from "@/components/product/ProductMain";

export default {
  name: "ProductList",
  components: { ProductMain },
  created() {
    this.goData()
  },
  data() {
    return {
      selected: false,
      list: [],
      product: '',
    }
  },
  methods: {
    goData() {
      axios.get('/api/product_list')
        .then((res) => {
          console.log(res.data);
          this.list = res.data;
        })
        .catch(e => {
          console.log(e)
        })
    },
    // path로 받기
    toDetail(product){
      this.$router.push({
        path: `/ProductDetail/${product.menuid}`
      })
    }

  }
}
</script>

<style scoped>

</style>
