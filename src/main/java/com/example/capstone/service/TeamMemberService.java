package com.example.capstone.service;


import com.example.capstone.domain.Plan.Plan;
import com.example.capstone.domain.Plan.TeamMember;
import com.example.capstone.repository.Plan.PlanRepository;
import com.example.capstone.repository.Plan.TeamMemberRepository;
import com.example.capstone.repository.Plan.TeamRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeamMemberService {
    private final TeamRepository teamRepository;
    private final TeamMemberRepository teamMemberRepository;
    private final PlanRepository planRepository;

    public TeamMemberService(TeamRepository teamRepository, TeamMemberRepository teamMemberRepository, PlanRepository planRepository) {
        this.teamRepository = teamRepository;
        this.teamMemberRepository = teamMemberRepository;
        this.planRepository = planRepository;
    }


//    public List<TeamMember> teamManagementPage(Member mcode){
//        List<TeamMember> tm = teamMemberRepository.findByMcode(mcode);
//   return tm;
//    }
//    public List<TeamMember> loadTeamMemberList(Team teamCode){
//        List<TeamMember> teamMcode = teamMemberRepository.findByteamCode(teamCode);
//        return teamMcode;
//    }

    public void acceptTeam(TeamMember teamMember) {

        List<TeamMember> acceptionCheck = teamMemberRepository.findByTeamCodeAndMcode(teamMember.getTeamCode(), teamMember.getMcode());
        acceptionCheck.get(0).setAcception("y");
        teamMemberRepository.findById(acceptionCheck.get(0).getMcode().getMCode());
        teamMemberRepository.save(acceptionCheck.get(0));
    }

    public void refuseTeam(TeamMember teamMember) {
        System.out.println("받아짐");
        List<TeamMember> acceptionCheck = teamMemberRepository.findByTeamCodeAndMcode(teamMember.getTeamCode(), teamMember.getMcode());
        teamMemberRepository.delete(acceptionCheck.get(0));
        System.out.println("거절성공");
    }

    public String addTeamMember(TeamMember teamMember) {

        List<TeamMember> checkMember = teamMemberRepository.findByTeamCodeAndMcode(teamMember.getTeamCode(), teamMember.getMcode());
        if (checkMember.isEmpty()) {
            teamMemberRepository.save(teamMember);
            return "y";
        } else {
            System.out.println("존재하는 회원입니다");
            return "n";
        }

    }

    public TeamMember loginedTeamCode(TeamMember teamMember) {
        List<TeamMember> tm = teamMemberRepository.findByTeamCodeAndMcode(teamMember.getTeamCode(), teamMember.getMcode());
        System.out.println(tm.get(0));
        return tm.get(0);
    }

    public List<Plan> loadTeamPlans(Long team) {
        List < Plan > plans = planRepository.findByTeamCodeTeamCode(team);
        return plans;

    }
}