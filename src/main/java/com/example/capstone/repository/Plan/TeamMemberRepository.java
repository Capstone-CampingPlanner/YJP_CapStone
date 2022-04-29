package com.example.capstone.repository.Plan;


import com.example.capstone.domain.Member.Member;
import com.example.capstone.domain.Plan.Team;
import com.example.capstone.domain.Plan.TeamMember;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

     @EntityGraph(attributePaths = {"teamCode"})
     List<TeamMember> findByMcode(Member MCode);

     @EntityGraph(attributePaths = {"mcode"})
     List<TeamMember> findByteamCode(Team teamCode);

     @EntityGraph(attributePaths = {"teamCode","mcode"})
     List<TeamMember> findByTeamCodeAndMcode(Team teamCode, Member mcode);
}

