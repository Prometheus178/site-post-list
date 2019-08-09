package com.realestate.site.models.post;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "photo_id")
    private Long id;

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Photo(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
