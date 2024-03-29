package study.querydsl.entity;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
@Commit
class HelloTest {
    @Autowired
    EntityManager em;

    @Test
    public void test(){
        Hello hello = new Hello();
        em.persist(hello);

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
//		QHello qHello = new QHello("h");
        QHello qHello = QHello.hello;
        Hello result = queryFactory
                .selectFrom(qHello)
                .fetchOne();
//
        Assertions.assertThat(result).isEqualTo(hello);
    }
}