<template>
  <div class="storage-view-main">

    <div v-if="get">
      <GetStorage></GetStorage>
      <button class="storage-back-btn" style="margin-top: -120%; margin-left: 80%; " @click="inputStorage">추가</button>
    </div>
    <div v-if="input">
      <button @click="getStorage" class="storage-back-btn">뒤로가기</button>
      <InputStorage></InputStorage>
    </div>

  </div>
</template>

<script>
import InputStorage from '@/components/storageService/admin/storage/InputStorage.vue'
import GetStorage from "@/components/storageService/admin/storage/GetStorage";

export default {

  name: "StorageView",
  components: {
    InputStorage,
    GetStorage
  },
  mounted() {
  },
  data() {
    return {
      get: true,
      input: false
    }
  },
  methods: {
    getStorage() {
      this.get = true
      this.input = false
    },
    inputStorage() {
      this.input = true
      this.get = false
    }
  }

}
</script>

<style scoped>
.storage-back-btn{
  margin-left: 2%;
  margin-top: 2%;
  text-align: center;
  width: 6%;
  padding: 0.5%;
  background-color: #ffffff;
  font-weight: bolder;
  color: #00a3de;
  border-color: #00a3de;
}
.storage-back-btn:hover{
  color: white;
  background-color: #b2e2fd;
}

</style>