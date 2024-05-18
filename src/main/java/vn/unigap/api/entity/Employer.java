package vn.unigap.api.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.*;
import lombok.Setter;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYER")
public class Employer {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @Getter
    @Column(name = "EMAIL", unique = true,nullable = false)
    private String email;

    @Setter
    @Getter
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PROVINCE",nullable = false)
    private Integer province;

    @Column(name = "DESCRIPTION")
    private String description;

    @Builder.Default
    @Column(name = "CREATED_AT")
    private Date createdDate = new Date();

    @Builder.Default
    @Column(name = "UPDATED_AT")
    private Date updatedDate = new Date();

}
