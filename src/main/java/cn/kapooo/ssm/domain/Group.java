package cn.kapooo.ssm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    private Long id;
    private String name;
    private List<Head> headList;
    private String newMsg;
    private String time;
}
