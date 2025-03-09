# Web Development 2
## HOÀNG DUY AN
### My profile:
* **🗓 Date of Birth**: 13/10/2004
* **🧑 Gender**       : male
* **🏤 Study at**     : Nha Trang University
* **💻 Falcuty**      : Information Technology
### Contact:
* [D AN Hoàng](https://www.facebook.com/hoangduyan2004)

![bc638a35af294c58d456cd6f9280b00c](https://github.com/user-attachments/assets/56320d47-38af-4104-a82d-afc83df14327)

## Kết quả một số bài tập đã làm
### 1. Web About Me
[Link bài tập ở đây](AboutMe)

![image](https://github.com/user-attachments/assets/075dfd50-f58c-41a1-8bf7-128b9d8f27ec)

### 2. Web Login
[Link bài tập ở đây](LoginPage)

|Hình ảnh 1|Hình ảnh 2|
|:---------|:---------|
|![image](https://github.com/user-attachments/assets/8bbec9f1-1b31-47c0-9440-0c5d4118cac8)|![image](https://github.com/user-attachments/assets/941bef58-ab37-49b4-99fe-2d51c54dd22b)|

### 3. BT Truyền dữ liệu vào view
[Link bài tập ở đây](https://github.com/Danne132/64130005_Web2/tree/9a3645fc5ef320e44cabf0aca244e774ca338085/SB_TruyenDuLieuSangView)
<br/> 👉 Code mẫu <br/>
_*Controller*_
```java
@GetMapping("/")
public String getMethodName(ModelMap model) {
  model.addAttribute("MSSV", "64130005");
  model.addAttribute("HoTen", "Hoàng Duy An");
  model.addAttribute("NamSinh", "2004");
  model.addAttribute("GioiTinh", "Nam");
  return "index";}
```
_*View*_
```html
<html xmlns:th="http://www.thymeleaf.org">
<div class="container">
  <div class = "content">
    <div>MSSV: <span th:text=${MSSV}></span></div>
    <div>Họ và Tên: <span th:text=${HoTen}></span></div>
    <div>Năm sinh: <span th:text=${NamSinh}></span></div>
    <div>Giới tính: <span th:text=${GioiTinh}></span></div>
  </div> 
</div>
</html>
```


