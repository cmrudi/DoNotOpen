# Tugas 2 IF3110 Pengembangan Aplikasi Berbasis Web

## Basis data sistem

Pada web ini, kami menggunakan 2 buah basis data. Sebenarnya, kami menggunakan basis data yang hampir mirip dengan basis data pada tugas sebelumnya, namun dengan beberapa modifikasi.

Jadi, kami memisahkan basis data tersebut menjadi 2 secara independen. Basis data pertama kami gunakan untuk menyuplai data-data yang dibutuhkan pada Identity Service. basis data ini mengandung tabel-tabel yang berhubungan dengan data user, autentikasi, dan sekaligus token untuk akses web.

Basis data kedua yaitu untuk Marketplace pada project kami. Jadi mengenai tabel-tabelnya, berhubungan dengan data-data produk yang nantinya menjadi basis data untuk Web Service.

-----

## Sharing Session dengan REST
REST : Respresentational State Transfer
REST adalah sebuah konsep dalam melakukan shared session / state transfer (karena Web itu stateless)
REST biasanya diimplementasikan di HTTP (biarpun bisa di teknologi yg lain juga)

Konsep :
- resource / sumber daya logical (berbentuk kelas biasanya)
- server : tempat menampung sumberdaya
- client : yang melakukan request pada server
- request dan response : interaksi antara client dan server
- representation : dokumen yg menjelaskan status dari sebuah resource

Prinsip
1. State dari resource diketahui hanya oleh internal dari server
2. Server tidak memiliki status dari client
3. Request dari client mengandung semua informasi untuk diproses server
4. Session state di store di client side
5. Resource bisa memiliki beberapa respresentation
6. Response mengindikasikan cacheability (bisa ketahuan perlu di cached atau tidak)
7. Opsional : client bisa fetch sebagian code server jika dibutuhkan

sumber: https://www.javacodegeeks.com/2012/10/introduction-to-rest-concepts.html

-------

## Pembangkitan Token dan expiry time

User melakukan input username dan password
Dari situ, user akan mendapatkan token
Token berguna untuk memperbolehkan user fetch resources
(Hanya sebagian resources saja yang boleh diakses user, misalnya, hanya user A yang boleh lihat status penjualan barangnya)
Dalam hal ini, kami memakai token generator yaitu UUID yang akan men-generate token alfanumerik

Konsep ini membantu dalam state handling, dimana user mendapat token, sehingga server tidak perlu menanyakan ulang username dan password pengguna. Namun, user tidak akan selamanya mendapat token. Hal ini disebut dengan expire time

Berapa lama expire time untuk token pada sebuah aplikasi?

Untuk program semacam ini, short expiry sudah cukup, kira-kira beberapa menit saja, : cukup untuk meng-cover second call apabila terjadi error pada first call
Apabila aplikasi ini mulai digunakan untuk session yang lebih lama, expire time bisa diperbesar. Waktu yang logis adalah 2 kali waktu rata-rata session
Cara settingnya yaitu melalui method setAge() pada Cookie

sumber: http://stackoverflow.com/questions/1592534/what-is-token-based-authentication
sumberhttp://softwareengineering.stackexchange.com/questions/193969/how-to-decide-the-token-expiry-time-in-rest-web-service

-----


## Kelebihan Arsitektur

Kelebihan dan kelemahan arsitektur aplikasi ini
Kelebihan :
1. Mudah melakukan pengujian karena aplikasi terbagi-bagi, tidak disatukan semuanya
2. Lebih mudah membuat security sistemnya, karena sudah dibentuk arsitektur yang baik (dibandingkan dengan monolitik)

Kelemahan :
1. Waktu untuk layanan proses seharusnya lebih lambat dibanding monolitik. Karena, pada monolitik, seluruh aplikasi berada pada alamat memory yang sama, sedangkan dengan arsitektur ini, aplikasi berada pada alamat memory yang berbeda-beda sehingga membutuhkan waktu layanan yang lebih lama

sumber: http://www.blog-hafid25.com/2015/09/arsitektur-sistem-operasi-dan.html?m=1

### Arsitektur Umum Server
![Gambar Arsitektur Umum Server](http://gitlab.informatika.org/IF3110_WebBasedDevelopment_2016/TugasBesar2_JavaAndWebService/raw/3747ba2499396d04f742a589a024876964383159/arsitektur_umum.png)




## Pembagian Kerja


REST :
1. Generate token : 13514057 & 13514033
2. Validasi token : 13514057
3. Logout : 13514057
4. Register Service : 13514057
5. Login Service : 13514057

SOAP :
1. Add Product : 13514057
2. Catalog : 13514057
3. Edit Product : 13514033
4. Your Product : 13514033
5. Confirmation Purchase : 13514033
6. Sales : 13514099
7. Purchases : 13514099

Web app (JSP) :
1. Halaman Login : 13514057
2. Halaman Register : 13514057
3. Halaman Add Product : 13514057
4. Halaman Catalog : 13514057
5. Halaman Edit Product : 13514033
6. Halaman Your Product : 13514033
7. Halaman Confirmation Purchase : 13514033
8. Halaman Sales : 13514099 & 13514033
9. Halaman Purchases : 13514099 & 13514033

Faza Thirafi 13514033 | Cut Meurah Rudi 13514057 | Drestanto M Dyasputro 13514099