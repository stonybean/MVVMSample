package com.github.stonybean.mvvmsample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ContactViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ContactRepository(application)
    private val contacts = repository.getAll()

    fun getAll(): LiveData<List<Contact>> {
        return this.contacts
    }

    suspend fun insert(contact: Contact) {
        repository.insert(contact)
    }

    suspend fun delete(contact: Contact) {
        repository.delete(contact)
    }
}