package com.example.capstone.controller.Plan;


import com.example.capstone.domain.Member.Member;
import com.example.capstone.domain.Plan.Plan;
import com.example.capstone.domain.Plan.Team;
import com.example.capstone.domain.Plan.TeamMember;
import com.example.capstone.repository.Member.MemberRepository;
import com.example.capstone.repository.Plan.TeamMemberRepository;
import com.example.capstone.repository.Plan.TeamRepository;
import com.example.capstone.service.PlanService;
import com.example.capstone.service.TeamMemberService;
import com.example.capstone.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping
public class TeamManagementApiController {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;
    private final TeamMemberRepository teamMemberRepository;
    private final PlanService planService;
    private final TeamMemberService teamMemberService;
    private final TeamService teamService;

    public TeamManagementApiController(MemberRepository memberRepository, TeamRepository teamRepository, TeamMemberRepository teamMemberRepository, PlanService planService, TeamMemberService teamMemberService, TeamService teamService) {
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
        this.teamMemberRepository = teamMemberRepository;
        this.planService = planService;
        this.teamMemberService = teamMemberService;
        this.teamService = teamService;
    }

    @PostMapping("/api/TeamManagementPage/{mcode}")
    public List<TeamMember> teamManagementPage(@PathVariable("mcode") Member mcode) {
        List<TeamMember> tm = teamMemberRepository.findByMcode(mcode);

        // List<TeamMember> tm = team_memberRepository.findByMcode(mcode);
        if (tm.isEmpty()) {
            return null;
        } else return tm;
    }

    @GetMapping("/api/loadTeamMemberList/{teamName}")
    public List<TeamMember> loadTeamMemberList(@PathVariable("teamName") String teamName) {
        Optional<Team> teamCode = teamRepository.findByTeamName(teamName);
        List<TeamMember> teamMcode = teamMemberRepository.findByteamCode(teamCode.get());
        if (teamMcode.isEmpty()) {
            return null;
        } else return teamMcode;
    }

    @PutMapping("/api/addTeam")
    public String addTeam(@RequestBody Team tm) {
        Optional<Team> newTeamName = teamRepository.findByTeamName(tm.getTeamName());
        if (newTeamName.isEmpty()) {
            teamRepository.save(tm);
            return "y";
        } else {
            return "n";
        }
    }

    @PostMapping("api/addTeamMember")
    public String addTeamMember(@RequestBody TeamMember teamMember) {
        return teamMemberService.addTeamMember(teamMember);
    }

    @PostMapping("/api/acceptTeam")
    public String acceptTeam(@RequestBody TeamMember teamMember) {
        teamMemberService.acceptTeam(teamMember);
        return "y";
    }

    @PostMapping("/api/refuseTeam")
    public String refuseTeam(@RequestBody TeamMember teamMember) {
        teamMemberService.refuseTeam(teamMember);
        return "y";
    }

    @PostMapping("/api/deleteTeam")
    public String deleteTeam(@RequestBody Team team) {
        teamService.deleteTeam(team);
        return "y";
    }

    @PostMapping("/api/loginedTeamCode")
    public TeamMember loginedTeamCode(@RequestBody TeamMember teamMember) {
        System.out.println("teamMember = " + teamMember);
        System.out.println("logined 받아짐");
        return teamMemberService.loginedTeamCode(teamMember);
    }

    @GetMapping("/api/loadTeamPlans/{teamCode}")
    public List<Plan> loadTeamPlans(@PathVariable("teamCode") Long team) {
//        //== test ==//
//        TeamDto teamDto = TeamDto.builder()
//                .teamCode(1L)
//                .build();

        return teamMemberService.loadTeamPlans(team);

    }

}