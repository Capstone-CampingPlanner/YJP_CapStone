package com.example.capstone.repository.Member;

import com.example.capstone.domain.Member.Company;
import com.example.capstone.domain.Member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    public Optional<Company> findCompanyByCCode(String CCode);
    public Optional<Company> findCompanyByMember(Member member);
}
