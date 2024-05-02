package study.querydsl.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {
    private String username;
    private int age;

    // QueryProjection 사용시 dto 자체가 queryDsl에 대한 의존성을 갖게 됨
    // 아키텍처 쪽으로 순수 dto를 가져갈 수 없는 단점
    @QueryProjection
    public MemberDto(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
