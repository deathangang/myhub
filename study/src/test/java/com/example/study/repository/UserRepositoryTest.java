package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import com.example.study.model.enumclass.UserStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;


public class UserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        String account = "Test03";
        String password = "Test03";
        UserStatus status = UserStatus.REGISTERED;
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-3333";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";


        User user = new User();

        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);



        User newUser = userRepository.save(user);

        Assertions.assertNotNull(newUser);

        /*
        User user = new User();
        user.setAccount("TestUser03");
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1111-3456");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("test3");

        User newUser = userRepository.save(user);
        System.out.println("newUser: " +newUser);

         */
    }

    @Test
    @Transactional
    public void read(){
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        if(user != null) {
            user.getOrderGroupList().forEach(orderGroup -> {

                System.out.println("------------주문묶음--------------");
                System.out.println("수령인 : " + orderGroup.getRevName());
                System.out.println("수령지 : " + orderGroup.getRevAddress());
                System.out.println("총금액 : " + orderGroup.getTotalPrice());
                System.out.println("총수량 : " + orderGroup.getTotalQuantity());

                System.out.println("------------주문상세--------------");
                orderGroup.getOrderDetailList().forEach(orderDetail -> {
                    System.out.println("파트너사이름: " + orderDetail.getItem().getPartner().getName());
                    System.out.println("파트너사카테고리: " + orderDetail.getItem().getPartner().getCategory().getTitle());
                    System.out.println("주문상품: " + orderDetail.getItem().getName());
                    System.out.println("고객센터: " +orderDetail.getItem().getPartner().getCallCenter());
                    System.out.println("주문의 상태: " +orderDetail.getStatus());
                    System.out.println("도착예정일자: " +orderDetail.getArrivalDate());


                });

            });
            
            
        }

        Assertions.assertNotNull(user);
    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser ->{
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);

            //System.out.println("user: " +selectUser);
            //System.out.println("email: " +selectUser.getEmail());
        });
    }

    @Test
    @Transactional
    public void delete() {
        Optional<User> user = userRepository.findById(3L);

        Assertions.assertTrue(user.isPresent());
        user.ifPresent(selectUser ->{
           userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(3L);

        Assertions.assertFalse(deleteUser.isPresent());

    }
}
