package com.example.sprintproject_blog.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "post_table")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", nullable = false, updatable = false)
    private Date createDateTime;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "edit_date")
    private Date editDateTime;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(columnDefinition = "TEXT")
    private String body;

    public Post() {}

    public Post(String title, User user, String body) {
        super();
        this.title = title;
        this.user = user;
        this.body = body;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public Date getCreateDateTime() {
        return this.createDateTime;
    }

    public Date getEditDateTime() {
        return this.editDateTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return this.body;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public void setEditDateTime(Date editDateTime) {
        this.editDateTime = editDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        int edited = createDateTime.compareTo(editDateTime);
        SimpleDateFormat dt = new SimpleDateFormat();

        if (edited == 0) {
            return dt.format(createDateTime);
        } else {
            return dt.format(createDateTime) + ", edited " + dt.format(editDateTime);
        }
    }
}
