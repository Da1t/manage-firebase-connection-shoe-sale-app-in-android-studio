package com.example.dean;

public class ShoeAdmin {
  //  private int id;
    private  String name;
    private String brandname;
    private String imageUrl;
  //  public ShoeAdmin(int id, String name, String brandname, String imageUrl)

    public ShoeAdmin( String name, String brandname, String imageUrl) {
    //    this.id = id;
        this.name = name;
        this.brandname = brandname;
        this.imageUrl = imageUrl;
    }

   // public int getId() {
 //       return id;
 //   }

 //   public void setId(int id) {
  //      this.id = id;
  //  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
