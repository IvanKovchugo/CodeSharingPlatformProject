package com.ivankauchuha.codesharingplatformproject.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Data
@Entity
@JsonIgnoreProperties(value = {"id", "timeLimit", "viewsLimit", "initialTime"})
@NoArgsConstructor
public class Code {


    @Id
    @Column
//    @GeneratedValue(strategy = GenerationType.UUID)
    private String id = String.valueOf(UUID.randomUUID());

    @Column(length = 4096)
    private String code;

    @Column
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime date = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

    @Column
    private Long time;

    @Column
    private Long views;

    @Column Long initialTime;

    @Column
    private boolean viewsLimit;

    @Column
    private boolean timeLimit;

    public Code(Code code) {
        this.id = code.getId();
        this.code = code.getCode();
        this.date = code.getDate();
        this.time = code.getTime() == null ? 0L : code.getTime();
        this.views = code.getViews() == null ? 0L : code.getViews() ;
        this.initialTime = code.getTime();

        if (this.time > 0) {
            this.timeLimit = true;
        }

        if (this.views > 0) {
            this.viewsLimit = true;
        }
    }

    public boolean hasLimit() {
        return isTimeLimit() || isViewsLimit();
    }



    //    public Code(Code code) {
//        this.id = code.getId();
//        this.code = code.getCode();
//        this.date = code.getDate();
//    }
//
//    public Code(String code, LocalDateTime date) {
//        this.code = code;
//        this.date = date;
//    }

}
