package com.springbootaws.book.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass       // jpa entity 클래스들이 basetimeentity을 상속할 경우 필드들도 컬럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class)  //BaseTimeEntity 클래스에 auditing 기능을 포함함
public class BaseTimeEntity {
    @CreatedDate    // entity가 생성되어 저장될 때 자동으로 시간이 저장됨
    private LocalDateTime createdDate;

    @LastModifiedDate   // 조회한 entity의 값을 변경할 때 시간이 자동 저장됨
    private LocalDateTime modifiedDate;
}
