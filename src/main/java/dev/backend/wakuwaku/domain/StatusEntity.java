package dev.backend.wakuwaku.domain;


import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
public abstract class StatusEntity extends BaseEntity{
    protected String checkStatus;
}
