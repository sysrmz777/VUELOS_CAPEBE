package com.example.appvuelos_capebe.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appvuelos_capebe.data.local.entity.UsuarioEntity

@Dao
interface UsuarioDao {

    // insertar usuario
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun registerUser(user: UsuarioEntity)

    // buscar por correo
    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    suspend fun getUserByEmail(email: String): UsuarioEntity?

}
