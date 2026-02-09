package NetZero.JpaRepositoryTest;

import NetZero.domain.Member;
import NetZero.domain.PointHistory;
import NetZero.repository.MemberRepository;
import NetZero.repository.PointHistoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class RepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PointHistoryRepository pointHistoryRepository;

    @Test
    @DisplayName("회원가입 후 포인트 적립 내역이 잘 저장되는지 스프링 데이터 이용하여 확인")
    void saveMemberAndPointTest(){
        //Given
        Member member = new Member("test1", "홍길동", "gilDDong", 0);
        memberRepository.save(member);
        //When
        PointHistory pointHistory = new PointHistory(member, 100, "100보 걷기 보상");
        pointHistoryRepository.save(pointHistory);
        //Then

        Member find1member = memberRepository.findById("test1").orElse(null);
        assertThat(find1member).isNotNull();
        assertThat(find1member.getUsername()).isEqualTo("홍길동");

        List<PointHistory> points = pointHistoryRepository.findByMember(find1member);
        
        assertThat(points).hasSize(1);
        assertThat(points.get(0).getAmount()).isEqualTo(100);

        System.out.println("테스트 성공이요. 저장된 회원 이름 " + find1member.getUsername());
    }

}
