package br.com.apduarte.apiservice.domain;

import jakarta.persistence.*;
        import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "alerts")
public class Alert {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 60)
    private String type;

    @Lob
    @Column(nullable = false)
    private String payload;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private AlertStatus status;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    protected Alert() {
        // JPA only
    }

    public Alert(String type, String payload) {
        this.type = type;
        this.payload = payload;
        this.status = AlertStatus.CREATED;
        this.createdAt = Instant.now();
    }

    public UUID getId() { return id; }
    public String getType() { return type; }
    public String getPayload() { return payload; }
    public AlertStatus getStatus() { return status; }
    public Instant getCreatedAt() { return createdAt; }
}

