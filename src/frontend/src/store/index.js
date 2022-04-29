import {createStore} from 'vuex';
import createPersistedState from 'vuex-persistedstate'

export default createStore({
    state: {
        loginState:null,
        stateCode:null,
        teamName: '',
        mcode: '',
        teamList: [],
        teamMembers: [],
        teamMemberList: [],
        insertName: '',
        teamCode: '',
        diff: 0,
        planCode: '',
        loginedTeamCode: '',
    },
    getters: {
        getLoginState(state){
            return state.loginState
        }
    },
    mutations: {
        setLoginState(state, loginState, stateCode, mcode){
            state.loginState = loginState
            state.stateCode = stateCode
            state.mcode = mcode
        },
        setLogoutState(state){
            state.loginState = null
            state.stateCode = null
            state.mcode = null
        },
        updateTeamList(state, teamMember) {
            state.teamList.push(teamMember);
        },
        updateMyTeam(state, mcode) {
            state.mcode = mcode;
        },
        updateTeamName(state, teamName) {
            state.teamName = teamName;
        },
        updateTeamMemberList(state, mname) {
            state.teamMemberList.push(mname);
        },
        updateTeamCode(state, teamCode) {
            state.teamCode = teamCode;
        },
        updateDiff(state, diff) {
            state.diff = diff;
        },
        updatePlanCode(state, planCode) {
            console.log('a뭐가저장됐나~' + planCode);
            state.planCode = planCode;
        },
        updateLoginedTeamCode(state, loginedTeamCode) {
            state.loginedTeamCode = loginedTeamCode;
        },
    },
    actions: {
    },

    plugins:[
        createPersistedState()
    ]
});