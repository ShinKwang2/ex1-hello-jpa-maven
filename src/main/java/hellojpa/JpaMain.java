package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            //생성
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloA");
//            em.persist(member);


//            //조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

//            //삭제
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

//            //수정 (em.persist(findMember)를 마지막에 넣을 필요가 없음 - 더티 체킹)
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

//            //전체조회
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

//            //비영속 - 객체를 생성한 상태
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

//            //영속 - 객체를 저장한 상태
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");

//            //준영속 상태 - 회원 엔티티를 영속성 컨텍스트에서 분리
//            em.detach(member);

//            // 삭제 - 객체를 삭제한 상태
//            em.remove(member);

//            //영속 엔티티의 동일성 보장
//            Member member1 = em.find(Member.class, 101L);
//            Member member2 = em.find(Member.class, 101L);
//            System.out.println("result = " + (member1 == member2 ));

//            //엔티티 등록 - 트랜잭션을 지원하는 쓰기 지연
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("===================");

//            //엔티티 수정 - 변경감지(더티체킹)
//            Member findMember = em.find(Member.class, 150L);
//            findMember.setName("ZZZZZZZ");
//            //em.persist(member) 혹은 em.update(member) 와 같은 명령을 할 필요가 없음

//            //flush - 변경 감지, 수정된 엔티티 쓰기 지연 SQL 저장소에 등록, 쿼리를 DB에 전송
//            //flush는 영속성 컨텍스트를 비우지 않음, 다만 DB에 동기화
//            Member member = new Member(200L, "Member200");
//            em.persist(member);
//            em.flush();
//            System.out.println("===================");
//            // ========= 전에 insert 쿼리 발행

            //영속에서 준영속으로
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAAA");
//            em.detach(member); //특정 엔티티만 준영속 상태로 전환
//            em.clear();        //영속성 컨텍스트를 완전히 초기화
//            em.close();        //영속성 컨텍스트를 종료
//            Member member2 = em.find(Member.class, 150L);

//            Member member = new Member();
////            member.setId("ID_A");
//            member.setUsername("C");
////            member.setRoleType(RoleType.GUEST);
//            System.out.println("===================");
//            em.persist(member);
//            System.out.println("member.id = " + member.getId());
//            System.out.println( "===================");

            Member member1 = new Member();
            member1.setUsername("A");

            Member member2 = new Member();
            member2.setUsername("B");

            Member member3 = new Member();
            member3.setUsername("C");

            System.out.println( "===================");

            //DB SEQ = 1    |   1
            //DB SEQ = 51   |   2
            //DB SEQ = 51   |   3

            em.persist(member1);    //1, 51 처음에는 더미로 맞춤
            em.persist(member2);    //MEM
            em.persist(member3);    //MEM

            System.out.println("member1 = " + member1.getId());
            System.out.println("member2 = " + member2.getId());
            System.out.println("member3 = " + member3.getId());

            System.out.println( "===================");


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}
