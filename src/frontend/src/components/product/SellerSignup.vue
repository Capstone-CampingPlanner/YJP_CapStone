<template>
  <div>
    <ProductMain></ProductMain>
    <br>
    <b-form  v-on:submit.prevent="submitForm">
      <label for="feedback-user">아이디</label>
      <b-form-input v-model="userid" placeholder="아이디를 입력하세요." :state="validation" id="feedback-user"></b-form-input>
      <b-form-invalid-feedback :state="validation">
        5~12자리로 작성해주세요.
      </b-form-invalid-feedback>
      <b-form-valid-feedback :state="validation">
        Looks Good.
      </b-form-valid-feedback>

      <label for="text-password">비밀번호</label>
      <b-form-input v-model="password" placeholder="비밀번호를 입력하세요." type="password" id="text-password" aria-describedby="password-help-block"></b-form-input>
      <b-form-text id="password-help-block">
        Your password must be 8-20 characters long, contain letters and numbers, and must not
        contain spaces, special characters, or emoji.
      </b-form-text>


      <label for="text-select">판매유형</label>
      <b-form-select v-model="sales_type" :options="options"></b-form-select>
      <div class="mt-3">선택유형 : <strong>{{ sales_type }}</strong></div>


      <br>
      <label for="text-select2">결제방법</label>
      <b-form-select v-model="payment" :options="options2"></b-form-select>
      <div class="mt-3">선택유형 : <strong>{{ payment }}</strong></div>

      <br>
      <label for="text-select3">사업자 번호</label>
      <b-form-input v-model="business_number" placeholder="사업자 번호를 입력하세요." :state="business_number" id="feedback-user"></b-form-input>
    </b-form>

    <br>
    <b-button type="submit" @click="signSubmit" pill variant="primary">등록하기</b-button>

  </div>
</template>

<script>
import axios from 'axios'
import ProductMain from "@/components/product/ProductMain";

export default {
  name: "Signup",
  components: { ProductMain },

  data() {
    return {
      userid: '',
      password: '',
      sales_type: '',
      payment: '',
      business_number: '',

      options: [
        { value: null, text: '판매하실 상품의 유형을 선택해주세요'},
        { value: '렌탈', text: '렌탈 물품'},
        { value: '판매', text: '판매 물품'},
      ],
      options2: [
        { value: null, text: '결제하실 유형을 선택해주세요'},
        { value: '신용카드', text: '신용카드'},
        { value: '카카오페이', text: '카카오페이'},
      ],
      options3: [
        { value: null, text: '사업자번호를 입력해주세요'},
        { value: '신용카드', text: '신용카드'},
        { value: '카카오페이', text: '카카오페이'},
      ]
    }
  },
  methods: {
    signSubmit: function () {
        console.log(this.userid, this.password, this.sales_type, this.payment, this.business_number);
        const url = 'http://localhost:8282/api/sellerSignup'
        const data = {
          userid: this.userid,
          password: this.password,
          sales_type: this.sales_type,
          payment: this.payment,
          business_number: this.business_number,
        }
        axios.post(url, data, { headers: { 'Content-Type': 'application/json'}})
          .then(res => {
            console.log("성공");
            alert("회원가입이 정상적으로 등록되었습니다.");
            this.$router.push({
              name: "UserList"
            });
          })
          .catch(function(error) {
            console.log(error);
            alert("회원가입이 실패하였습니다.");
          })
      }


  },
  computed: {
    validation() {
      return this.userid.length > 4 && this.userid.length < 13
    }
  }


}
</script>

// scss 정의
<style>

</style>
