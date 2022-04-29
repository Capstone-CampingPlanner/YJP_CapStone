<template>
	<h2>SELECT CAMPING PLACE</h2>
	<button @click="next()"></button>
</template>

<script>
export default {
	data() {
		return {};
	},
	methods: {
		next: function () {
			this.$router.push({ name: 'detailPlan' });
		},
	},
};
</script>

<style></style>
