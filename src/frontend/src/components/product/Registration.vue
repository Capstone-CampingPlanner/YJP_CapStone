<template>
  <ProductMain></ProductMain>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
  <br>
  <h1>상품 등록 페이지 입니다.</h1>
  <br>
  <div class="products-info">
    <div class="product-input-form">
      <label for="text-select">상품분류</label>

      <form v-on:submit.prevent="formSubmit" method="post" enctype="multipart/form-data">
        <select v-model="kindid" class="form-select" aria-label="Default select example">
          <option v-for="(option, index) in options" :key="index" :value="option">
            {{option.text}}
          </option>
        </select>
        <div class="mt-3">선택유형 : <strong>{{ kindid.text }}</strong></div>

        <form class="was-validated">
          <div class="mb-1">
            <label for="validationTextarea" class="form-label">메뉴명</label>
            <textarea v-model="menuname" :state="menuname" id="feedback-user" class="form-control is-invalid" placeholder="메뉴명을 입력하세요." required></textarea>
          </div>
        </form>
        <br>
        <form class="was-validated">
          <div class="mb-1">
            <label for="validationTextarea" class="form-label">수량</label>
            <textarea v-model="stock" id="feedback-user" class="form-control is-invalid" placeholder="수량을 입력하세요." :state="stock" required></textarea>
          </div>
        </form>


        <br>
        <form class="was-validated">
          <div class="mb-1">
            <label for="validationTextarea" class="form-label">가격</label>
            <textarea v-model="price" id="feedback-user" class="form-control is-invalid" placeholder="가격을 입력하세요." :state="stock" required></textarea>
          </div>
        </form>


        <br>
        <form class="was-validated">
          <div class="mb-1">
            <label for="validationTextarea" class="form-label">설명</label>
            <textarea v-model="ex" class="form-control is-invalid" placeholder="설명을 입력하세요." :state="ex" id="feedback-user" required></textarea>
          </div>
        </form>

        <br>
        <div class="input-group">
          <form>
            <input type="file"
                   id="file"
                   @change="handleImage"
                   enctype="multipart/form-data"
                   aria-describedby="inputGroupFileAddon04"
                   aria-label="Upload"
                   placeholder="상품을 설명할 이미지 파일을 업로드하세요."
                   drop-placeholder="Drop file here..." >
          </form>
        </div>


      </form>
    </div>
    <br>
  </div>
  <button variant="outline-primary" type="submit" @click="ProductSubmit">등록하기</button>
</template>


<script>
import axios from 'axios'

import ProductMain from "@/components/product/ProductMain";
import store from "@/store";

// let changeFile;
export default {
  name: "Registration",
  components: { ProductMain },
  data() {
    return {
      kindid: '',
      menuname: '',
      stock: '',
      price: '',
      ex: '',
      file: '',
      mid: store.getters.getLoginState.loginState,

      id: '',
      myContent: [],


      options: [
        { value: null, text: '판매하실 상품의 유형을 선택해주세요'},
        { value: '1', text: '캠핑'},
        { value: '2', text: '구매'},
        { value: '3', text: '렌탈'},
      ],

    }
  },

  methods: {
    handleImage(e) {
      this.file = e.target.files[0];
      let self = this;
      if(e.target.files[0]) {
        // 파일 읽는 라이브러리
        const reader = new FileReader();

        // 파일 읽기가 완료되는 시점
        reader.addEventListener('load', function(e1){
          // 완료되는 시점!!!!!!!!!!!!!!!
          self.imgsrc = e1.target.result;
          // 지금 reader 안에서는 this 못 씀. 그래서 35줄에 this를 self로 변수지정함
        });

        // 파일 읽기 시작
        reader.readAsDataURL(e.target.files[0]);
      }
      else {
        return false
      }

    },
    ProductSubmit: function () {
      const formData = new FormData();

      // const photoFile = document.getElementById("file_load");

      formData.append('kindid', this.kindid.value);
      formData.append('menuname', this.menuname);
      formData.append('stock', this.stock);
      formData.append('price', this.price);
      formData.append('ex', this.ex);
      formData.append('file', this.file);
      formData.append('mid', this.mid);



      console.log(this.kindid.value, this.menuname, this.stock, this.price, this.ex, this.file, this.mid);
      const baseURI = 'http://localhost:9002';

      axios.post(`${baseURI}/api/product_signup`, formData, { headers: { 'Content-Type': 'multipart/form-data'}} )
        .then(res => {
          console.log("성공" + res);
          alert("상품이 등록되었습니다.");
          this.$router.push({
            name: "MyProductList"
          });
        })
        .catch(function (error) {
          console.log("에러" + error);
          alert("상품이 등록되지않았습니다.");
        })


    },

  },
  computed: {

  }
}
</script>

<style scoped>
h1{
  text-align: center;
}
.products-info{
  display: flex;
  justify-content: center;
  align-items: center;
}
.product-input-form{
  width: 30%;
  text-align: center;
}
button{
  margin-left: 49%;
  margin-top: 3%;
}
</style>
