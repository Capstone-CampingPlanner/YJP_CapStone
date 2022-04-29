<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="/registration">상품 등록</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">

          <li class="nav-item">
            <a class="nav-link" href="/MyProductList">나의 상품</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/ProductList" active>상품 리스트</a>
          </li>
        </ul>
      </div>
    </div>

  </nav>
</template>

<script>
import ProductList from "@/components/product/ProductList";

export default {
  name: "main",
  components: {ProductList}
}
</script>

<style scoped>

.navbar navbar-expand-lg navbar-light bg-light {
  justify-content: center;
}
</style>