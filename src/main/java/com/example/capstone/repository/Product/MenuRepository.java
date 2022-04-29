package com.example.capstone.repository.Product;

import com.example.capstone.domain.Member.Member;
import com.example.capstone.domain.Product.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

//    Optional<Menu> findByMember(Member MID);
    List<Menu> findByMID(Member member);
    List<Menu> findByMIDMID(String mid);
//    @Query("select m from Menu m where m.menuname = :menuname")
//        List<Menu> findAllByMenuList(@Param("menuname") String menuname);


//    List<Menu> findByKind(Kind kind);
//
//    List<Menu> findBykind(Kind kindid);
//
//    List<Menu> findByMember(Member userid);
//        List<Menu> findByMenuname(Menu menuname);


//    Optional<Menu> findByMenuAndDeleteYN(String menuname, String deleteYN);
//
//    Optional<Menu> findByMenuname(String menuname);
}
