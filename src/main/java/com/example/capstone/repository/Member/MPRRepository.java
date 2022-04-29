package com.example.capstone.repository.Member;

import com.example.capstone.domain.Member.MemberPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MPRRepository extends JpaRepository<MemberPreference, Long> {
}
