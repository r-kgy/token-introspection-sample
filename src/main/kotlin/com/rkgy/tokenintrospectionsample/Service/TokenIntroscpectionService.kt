package com.rkgy.tokenintrospectionsample.Service

import com.google.gson.Gson
import com.rkgy.tokenintrospectionsample.Entity.AccessToken
import com.rkgy.tokenintrospectionsample.Entity.Response
import com.rkgy.tokenintrospectionsample.Repository.TokenIntrospectionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class TokenIntrospectionService @Autowired constructor(private val tokenIntrospectionRepository: TokenIntrospectionRepository) {

    fun fetchTokenInfo(token: String, tokenTypeHint: String) : ResponseEntity<String> {
        val token: AccessToken? = tokenIntrospectionRepository.fetch(token)
        token?.let {
            if (!it.isExepired()) {
                return ResponseEntity.ok(Gson().toJson(Response(true)))
            }
        }
        return ResponseEntity.ok(Gson().toJson(Response(false)))
    }
}
