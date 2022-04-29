<template>
  <h1>내가 등록한 상품 리스트, 여기서 수정 및 삭제 </h1>
  <div>
    <ProductMain></ProductMain>
    <br>
    <table class="table table-striped">
      <thead>
      <tr>
        <th>메뉴번호</th>
        <th>분류</th>
        <th>메뉴명</th>
        <th>설명</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="myProduct in list"
          :key="myProduct.id"
          :item="myProduct" @click="showInfo(myProduct)" style="cursor:pointer;">
        <th scope="row">{{ myProduct.menuid }}</th>
        <td>{{ myProduct.kindid.kindname }}</td>
        <td>{{ myProduct.menuname }}</td>
        <td>{{ myProduct.ex }}</td>
      </tr>
<!--      <router-link :to="{name: 'MyProductDetail', params: { menuid:myProduct.menuid }}"></router-link>-->
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios'
import ProductMain from "@/components/product/ProductMain";
import store from "@/store";

export default {
  name: "MyProductList",
  components: { ProductMain },

  created() {
    this.goMyData()
  },
  data() {
    return {
      selected: false,
      list: [],
      myProduct: '',
    }
  },
  methods: {
    goMyData() {
      this.user = store.getters.getLoginState.loginState
      console.log("현재 사용자 아이디는" + this.user)
      axios.get('http://localhost:9002/api/myProduct_list/'+this.user)
        .then((res) => {
          console.log(res.data);

          this.list = res.data;
        })
        .catch(e => {
          console.log(e)
        })
    },
    showInfo(myProduct) {
      this.$router.push({
        path: `/MyProductDetail/${myProduct.menuid}`
      })
    }

  }
}
</script>

<style scoped>

</style>
