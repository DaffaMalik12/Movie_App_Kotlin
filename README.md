# Movie App Kotlin

Movie App adalah aplikasi mobile yang dibuat menggunakan **Kotlin** untuk menampilkan daftar film populer, film mendatang, dan pencarian film. Aplikasi ini memanfaatkan API dari [The Movie Database (TMDb)](https://www.themoviedb.org/) untuk mengambil data film.

## Fitur

- **Daftar Film Populer**: Menampilkan film-film yang sedang populer saat ini.
- **Daftar Film Mendatang**: Menampilkan film yang akan datang.
- **Detail Film**: Menampilkan informasi lebih lengkap tentang film, termasuk sinopsis, rating, dan ulasan.
- **Pencarian Film**: Fitur untuk mencari film berdasarkan judul.
- **Offline Mode**: Menyimpan data film yang telah dilihat agar bisa diakses ketika tidak ada koneksi internet.

## Tech Stack

- **Kotlin**: Bahasa pemrograman utama untuk aplikasi Android.
- **Retrofit**: Digunakan untuk melakukan permintaan HTTP dan mengkonsumsi API TMDb.
- **Coroutines**: Untuk pengelolaan thread secara efisien.
- **ViewModel & LiveData**: Untuk mengelola UI dan data secara reaktif.
- **Glide**: Untuk memuat dan menampilkan gambar poster film.
- **Navigation Component**: Untuk navigasi antar halaman di dalam aplikasi.

## API

Aplikasi ini menggunakan API dari [The Movie Database (TMDb)](https://www.themoviedb.org/). Untuk mendapatkan API Key, Anda harus mendaftar dan mendapatkan kunci dari TMDb.

1. **Endpoint Film Populer**: `/movie/popular`
2. **Endpoint Film Mendatang**: `/movie/upcoming`
3. **Endpoint Pencarian Film**: `/search/movie`

## Instalasi

1. Clone repository ini:
   ```bash
   git clone https://github.com/DaffaMalik12/movie_app_kotlin.git
   cd movie_app_kotlin

