
package com.numetry.Travel.and.Tourism.Management.System.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEnquery {
    
      @Id
      @GeneratedValue(strategy=GenerationType.IDENTITY)
      private Long queryId;
      private  String querySubject;
      private String messsage;

      @ManyToOne
      @JoinColumn(name="userId")
      private User user;
     
}
