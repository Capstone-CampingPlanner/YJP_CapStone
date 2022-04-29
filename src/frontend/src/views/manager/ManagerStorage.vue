<template>
  매니저 - 보관소 관리
  <StorageDetail></StorageDetail>
</template>

<script>

import StorageDetail from "@/components/storageService/manager/StorageDetail";
export default {
  name: "ManagerStorage",
  components: {
    StorageDetail
  },
  mounted() {
    // if(store.getters.getLoginState.stateCode !== 4){
    //   this.$router.push('/')
    //   alert('보관소 매니저만 확인이 가능합니다')
    // }
  }
}
</script>

<style scoped>

</style>