package com.sa.kotlin_cleanarch.sample.di.koin

import androidx.room.Room
import com.sa.kotlin_cleanarch.sample.MyApplication
import com.sa.kotlin_cleanarch.sample.model.local.room_db.AppDB
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


/** Created by Sahil Bharti on 2/5/19.
 *
 *  Copyright (c) 2019 Sahil Inc. All rights reserved.
*/
var databaseModule = module {

    /** DB Singleton Provider */
    single {
        Room.databaseBuilder((androidApplication() as MyApplication), AppDB::class.java, "kotlin_sample.db")
            .build()
    }
    single { (get() as AppDB).contactDao() }

}