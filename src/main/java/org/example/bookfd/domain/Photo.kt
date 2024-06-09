package org.example.bookfd.domain

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "photo")
class Photo {
    @Id
    var id = 0
    var verification = false
    var name: String? = null
    var res: String? = null
    var path: String? = null
}
