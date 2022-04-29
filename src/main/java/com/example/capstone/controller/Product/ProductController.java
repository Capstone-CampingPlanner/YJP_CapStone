package com.example.capstone.controller.Product;

import com.example.capstone.domain.Member.Member;
import com.example.capstone.domain.Product.Kind;
import com.example.capstone.domain.Product.Menu;
import com.example.capstone.dto.Product.MenuDTO;
import com.example.capstone.repository.Member.MemberRepository;
import com.example.capstone.repository.Product.KindRepository;
import com.example.capstone.repository.Product.MenuRepository;
import com.example.capstone.service.ProductService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
//@CrossOrigin("*")
//@RequiredArgsConstructor
//@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@NoArgsConstructor
//@AllArgsConstructor  // @Autowired 대신사용
@RequestMapping("/api")
public class ProductController {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    KindRepository kindRepository;

    @Autowired
    ProductService productService;


    /* 전체상품 리스트 */
    @GetMapping("/product_list")
//    @JsonProperty("menu")
    public List<Menu> menuList() {
        List<Menu> menus = menuRepository.findAll();
        System.out.println(menus);
//        List<Menu> menuList = menuRepository.findAllByMemberList();

//        if (menus.isEmpty()) {
//            return null;
//        } else {
//            for (Menu m : menus) {
//                System.out.println(m.getKind().getKindname());
//                // return m.getKind().getKindname();
//            }
//        }
//        return menus;
        return menus;
    }

    /* 판매상품 상세 페이지 */
    @GetMapping("/product_detail/{menuid}")
    public Optional<Menu> getProduct_Detail(@PathVariable("menuid") int menuid) {
        System.out.println("메뉴번호 는" + menuid + "입니다.");

        Optional<Menu> menuDetailList = menuRepository.findById(menuid);
        return menuDetailList;

    }

    /* 나의상품 리스트 */
//    @GetMapping("/myProduct_list/{userid}")
////    @JsonProperty("menu")
//    public List<Menu> getMenuMyList(@RequestBody long userid) {
//
////        System.out.println(menuList.get(0).getKindid().getKindname());
////        List<Menu> myList = menuRepository.findAllByMenuList("dongmin");
//        System.out.println(userid + " 분 의 상품을 조회하겠습니다.");
//        Member user = productService.findByMemberId(userid);
////        List<Member> member = memberRepository.findByMID(menuDTO.getMid());
//        List<Menu> menuMyList = menuRepository.findByMID(user);
////        List<Member> members = memberRepository.findById(member);
//
//        return menuMyList;
//    }
    @GetMapping("/myProduct_list/{user}")
    public List<Menu> myMenuList(@PathVariable("user") String user) {
        List<Menu> myMenus = menuRepository.findByMIDMID(user);

//        List<Menu> myMenus = menuRepository.findAll();
//        List<Menu> menuList = menuRepository.findAllByMemberList();

//        if (menus.isEmpty()) {
//            return null;
//        } else {
//            for (Menu m : menus) {
//                System.out.println(m.getKind().getKindname());
//                // return m.getKind().getKindname();
//            }
//        }
//        return menus;
        return myMenus;
        // 한 행만 출력시 Optional , 전체 행은 List
    }

    /* 나의상품 상세페이지 */
    @GetMapping("/myProduct_detail/{menuid}")
    public Optional<Menu> getMyProduct_Detail(@PathVariable("menuid") int menuid) {
        System.out.println("메뉴번호 는" + menuid + "입니다.");

        Optional<Menu> myMenuDetailList = menuRepository.findById(menuid);
        return myMenuDetailList;

    }

    /* 나의상품 삭제 */
    @DeleteMapping("/myProduct_Delete/{menuid}")
    public String DeleteMyProduct_Detail(@PathVariable("menuid") int menuid) {
        System.out.println("삭제하실 메뉴번호는" + menuid + " 입니다.");
        Optional<Menu> menu = menuRepository.findById(menuid);

        menuRepository.deleteById(menuid);
        // menuService.deleteById(menuid);
        return "메뉴가 삭제되었습니다.";
    }


    /* 나의상품 수정 */
//    @PutMapping("/myProduct_Update/{menuid}")
//    public String UpdateMyProduct_Detail(ProductDetailDTO productDetailDTO) {
//        productService.savePost(productDetailDTO);
//        return "게시글이 수정되었습니다";
//    }

    @PutMapping("/myProduct_Update")
    public Menu UpdateMyProduct_Detail(@RequestParam(value = "file", required = false) MultipartFile uploadFile, Menu menu, MenuDTO menuDTO) throws IllegalStateException, IOException {
        System.out.println("파일 이름" + uploadFile.getOriginalFilename());
        System.out.println("파일 크기" + uploadFile.getSize());

//        Optional<Menu> updateMyMenu = menuRepository.findById(menu.getMenuid());
//        updateMyMenu.get().setMID(menu.getMID());
//        updateMyMenu.get().setEx(menu.getEx());
//        updateMyMenu.get().setMenuname(menu.getMenuname());
//        updateMyMenu.get().setPrice(menu.getPrice());
//        updateMyMenu.get().setStock(menu.getStock());
//        updateMyMenu.get().setKindid(menu.getKindid());

//        menuRepository.save(updateMyMenu.get());
        try {
            String origFilename = uploadFile.getOriginalFilename();

            UUID uuid = UUID.randomUUID();
            String filename = uuid + "_" + origFilename;
            /* 실행되는 위치의 'files' 폴더에 파일이 저장 */
            String savePath = System.getProperty("user.dir") + "\\src\\frontend\\src\\assets";
            /* 파일이 저장되는 폴더가 없으면 폴더 생성 */
            if (!new File(savePath).exists()) {
                try {
                    new File(savePath).mkdir();
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
            String filePath = savePath + "\\" + filename;
            uploadFile.transferTo(new File(filePath));

            menu.setOrigFilename(origFilename);
            menu.setFilename(filename);
            menu.setFilePath(filePath);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("123");
        }
        System.out.println(menu.getKindid());
        System.out.println(menu.getMenuid());

        /* menu.getMID() 하면 반환값이 String인데 타입은 Menu라서 Null로 뜸
           따라서 menuDTO.getMid() <- String 타입으로 넘겨서 member 테이블에서 'rigun'을 찾아줌
         */
        System.out.println(menuDTO.getMid());


//        List<Member> member = memberRepository.findByMID(menuDTO.getMid());
//
//        Optional<Kind> kind = kindRepository.findById(menuDTO.getKindid());
//



            menu.setSavedTime(LocalDateTime.now());

        Optional<Member> member = memberRepository.findByMID(menuDTO.getMid());

        System.out.println(member.get());
            menu.setMID(member.get());
        //            menu.setMID(memberRepository.findByMID("rigun").get());

        System.out.println(menu);
//

        menuRepository.save(menu);

        return menu;
    }


    /* 상품등록 페이지 */
    @PostMapping("/product_signup")
    public Menu addMenu(@RequestParam(value = "file", required = false) MultipartFile uploadFile, MenuDTO menuDTO) throws IllegalStateException, IOException {
        System.out.println("파일 이름" + uploadFile.getOriginalFilename());
        System.out.println("파일 크기" + uploadFile.getSize());

        // 경로지정
//        String path = "C:\\Vue-Spring\\src\\main\\resources\\static\\images";

        // 파일명 충돌방지(랜덤함수) 설정후 파일저장
//        UUID uuid = UUID.randomUUID();
//        String uuidFilename = uuid + "_" + uploadFile.getOriginalFilename();
//        File file = new File(path + uuidFilename);
//        uploadFile.transferTo(file);

//        String path = request.getSession().getServletContext().getRealPath("/").concat("resources");
//        System.out.println("path"+path);

        try {
            String origFilename = uploadFile.getOriginalFilename();
//            String filename = new MD5Generator(origFilename).toString();

            UUID uuid = UUID.randomUUID();
            String filename = uuid + "_" + origFilename;

            /* 실행되는 위치의 'files' 폴더에 파일이 저장 */
            String savePath = System.getProperty("user.dir") + "\\src\\frontend\\src\\assets";
            /* 파일이 저장되는 폴더가 없으면 폴더 생성 */
            if (!new File(savePath).exists()) {
                try {
                    new File(savePath).mkdir();
                }
                catch (Exception e) {
                    e.getStackTrace();
                }
            }
            String filePath = savePath + "\\" + filename;
            uploadFile.transferTo(new File(filePath));

            menuDTO.setOrigFilename(origFilename);
            menuDTO.setFilename(filename);
            menuDTO.setFilePath(filePath);


        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(menuDTO.getMid());
        Optional<Member> member = memberRepository.findByMID(menuDTO.getMid());


        Optional<Kind> kind = kindRepository.findById(menuDTO.getKindid());


        if(menuDTO.getSavedTime()==null)
            menuDTO.setSavedTime(LocalDateTime.now());


        Menu menu = new Menu(menuDTO.getMenuname(), menuDTO.getPrice(), menuDTO.getEx(), menuDTO.getSavedTime(), menuDTO.getStock(), menuDTO.getOrigFilename(), menuDTO.getFilename(), menuDTO.getFilePath(), kind.get(), member.get());
        System.out.println(menu);

        menuRepository.save(menu);

        return menu;
    }
}
