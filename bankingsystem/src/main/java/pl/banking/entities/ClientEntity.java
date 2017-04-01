package pl.banking.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dpp on 4/1/17.
 */


@Entity(name = "client")
@Table(name="CLIENTS")
@SequenceGenerator(name = "client_gen", sequenceName = "client_gen", allocationSize = 1)
public class ClientEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_gen")
    @Column (name = "client_id", nullable = false, updatable = false)
    private Long id;

    public ClientEntity() {
    }

    public Long getId() {
        return id;
    }
}
