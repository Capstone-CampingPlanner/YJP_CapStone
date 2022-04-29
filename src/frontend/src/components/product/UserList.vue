<template>
  <ProductMain></ProductMain>
  <div>
    <table class="table table-striped">
      <thead>
      <tr>
        <th>아이디</th>
        <th>비밀번호</th>
        <th>생성일</th>
        <th>결제유형</th>
        <th>판매유형</th>
        <th>사업자번호</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="item in list"
          :key="item.id"
          :item="item" @click='toDetail(item.userid)' style="cursor:pointer;">
        <th scope="row">{{ item.userid }}</th>

        <td>{{ item.password }}</td>
        <td>{{ item.savedTime }}</td>
        <td>{{ item.payment }}</td>
        <td>{{ item.sales_type }}</td>
        <td>{{ item.business_number }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios'
import ProductMain from "@/components/product/ProductMain";

export default {
  name: 'Product',
  components: { ProductMain },
  created() {
    this.fetchData()
  },
  data() {
    return {
      selected: false,
      list: [],
      item: '',
    }
  },
  methods: {
    fetchData() {
      const baseURI = 'http://localhost:8282';
      axios.get(`${baseURI}/api/user_list`)
        .then(response => {
          console.log(response.data);
          this.list = response.data;
        })
        .catch(error => {
          console.log(error)
        })
    },
    toDetail(contentId) {
      this.$router.push({
        name: ""
      })
    }


  }
}
</script>

<style>

</style>
