<template>
	<h1>아래 정보는 AI추천기능을 위해 사용됩니다</h1>
	<h1>날짜 선택</h1>
	<Datepicker
		v-model="shareDate"
		:enable-time-picker="false"
		:min-date="today"
		range
		placeholder="Select share date range"
		v-on="toString()"
		format="yyyy/MM/dd"
		autoApply
		:closeOnAutoApply="false"
	></Datepicker>
	<h2>{{ this.$store.state.diff - 1 }}박{{ this.$store.state.diff }}일</h2>
	<input
		type="text"
		@keyup="checkPlanName"
		placeholder="플랜이름"
		v-model="planName"
	/>
	<p>{{ checkResult }}</p>
	<h3>
		장소
		<select v-model="planDestination">
			<option disabled value="">지역선택</option>
			<option>강원</option>
			<option>경기</option>
			<option>경남</option>
			<option>경북</option>
			<option>광주</option>
			<option>대구</option>
			<option>대전</option>
			<option>부산</option>
			<option>서울</option>
			<option>인천</option>
			<option>전남</option>
			<option>전북</option>
			<option>제주</option>
			<option>충북</option>
		</select>
	</h3>

	<h4>
		종류
		<select v-model="planType">
			<option disabled value="">캠핑종류선택</option>
			<option>오토캠핑</option>
			<option>글램핑</option>
			<option>백패킹</option>
		</select>
	</h4>
	<h3>인원</h3>
	<button v-on:click="planNumber += 1">+</button>
	<p>{{ planNumber }}</p>
	<button v-on:click="planNumber -= 1">-</button>
	<h3>예상 경비</h3>
	<input type="number" placeholder="0" v-model="planBudget" />

	<button @click="createPlan()">다음</button>
</template>

<script>
import axios from 'axios';
import Datepicker from '@vuepic/vue-datepicker';
import dayjs from 'dayjs';
import '@vuepic/vue-datepicker/dist/main.css';
export default {
	components: { Datepicker },
	data() {
		return {
			shareDate: [],
			today: new Date(),
			planStart: '',
			planEnd: '',
			planDestination: '',
			planType: '',
			planNumber: 0,
			planBudget: '0',
			planName: '',
			checkResult: '',
			planCode: '',
			diff: '',
		};
	},
	methods: {
		checkPlanName: function () {
			const url = 'api/checkPlanName';
			this.checkResult = '';
			axios
				.post(url, {
					teamCode: this.$store.state.teamCode.teamCode,
					planName: this.planName,
				})
				.then((response) => {
					if (response.data === 'y') {
						this.checkResult = '사용가능한 플랜이름입니다';
					} else {
						this.checkResult =
							'사용불가능한 플랜이름입니다. 다시 시도하세요';
						this.planName = '';
					}
				})
				.catch((error) => {
					console.log(error);
				});
		},
		toString: function () {
			const firstValue = dayjs(this.shareDate[0]);
			this.planStart = firstValue.format('YYYYMMDD');
			const secondValue = dayjs(this.shareDate[1]);
			this.planEnd = secondValue.format('YYYYMMDD');
			this.diff = secondValue.diff(firstValue, 'd') + 1;
			this.$store.commit('updateDiff', this.diff);
			// console.log(this.$store.state.diff);
		},
		createPlan: function () {
			if (
				this.planName !== '' &&
				this.planBudget !== '' &&
				this.planNumber !== '' &&
				this.planType !== '' &&
				this.planDestination !== '' &&
				this.planEnd !== '' &&
				this.planStart !== ''
			) {
				console.log(this.$store.state.teamCode.teamCode); // store로 저장하면 안된다 디비에 값을 넣어 디테일플랜에서 디비값을 참조해야한다. 나중에 바꾸자
				const url = '/api/createPlan';

				axios
					.post(
						url,

						{
							planName: this.planName,
							teamCode: this.$store.state.teamCode.teamCode,
							planStart: this.planStart,
							planEnd: this.planEnd,
							planDestination: this.planDestination,
							planType: this.planType,
							planNumber: this.planNumber,
							planBudget: this.planBudget,
							planTotalDate: this.diff,
						},
					)
					.then((response) => {
						this.planCode = response.data;

						this.$store.commit('updatePlanCode', response.data);
						// response.date는  {planCode: 251, teamCode: {…}, planDestination: '대구', planName: '123', planBudget: 0,

						this.$router.push({
							name: 'detailPlan',
						});
					})
					.catch((error) => {
						alert('에러');
						console.log(error);
					});
			} else {
				alert('모든 입력값을 입력하세요');
			}
		},
	},
};
</script>

<style></style>
