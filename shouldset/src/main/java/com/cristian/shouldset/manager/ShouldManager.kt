package com.cristian.shouldset.manager

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject

object ShouldManager {

    private lateinit var mSharedPreferenceManager: SharedPreferences
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val mStringPreferenceList: MutableMap<String, BehaviorSubject<String>> = mutableMapOf()
    private val mBooleanPreferenceList: MutableMap<String, BehaviorSubject<Boolean>> = mutableMapOf()
    private val mIntPreferenceList: MutableMap<String, BehaviorSubject<Int>> = mutableMapOf()
    private val mFloatPreferenceList: MutableMap<String, BehaviorSubject<Float>> = mutableMapOf()
    private val mLongPreferenceList: MutableMap<String, BehaviorSubject<Long>> = mutableMapOf()


    // TODO: throw an exception when ShouldManager has not been initialized
    fun init(context: Context) {
        mSharedPreferenceManager = PreferenceManager.getDefaultSharedPreferences(context)
    }

    /**
     *
     */
    fun getBooleanAsBehaviorSubject(key: String, defValue: Boolean): BehaviorSubject<Boolean> {
        if (mBooleanPreferenceList[key] == null) {
            mBooleanPreferenceList[key] = BehaviorSubject.create()
            mBooleanPreferenceList[key]?.onNext(mSharedPreferenceManager.getBoolean(key, defValue))
        }

        return mBooleanPreferenceList[key]!!
    }

    /**
     *
     */
    fun getStringAsBehaviorSubject(key: String, defValue: String): BehaviorSubject<String> {
        if (mStringPreferenceList[key] == null) {
            mStringPreferenceList[key] = BehaviorSubject.create()
            mStringPreferenceList[key]?.onNext(mSharedPreferenceManager.getString(key, defValue))
        }

        return mStringPreferenceList[key]!!
    }

    /**
     *
     */
    fun getIntAsBehaviorSubject(key: String, defValue: Int): BehaviorSubject<Int> {
        if (mIntPreferenceList[key] == null) {
            mIntPreferenceList[key] = BehaviorSubject.create()
            mIntPreferenceList[key]?.onNext(mSharedPreferenceManager.getInt(key, defValue))
        }

        return mIntPreferenceList[key]!!
    }

    /**
     *
     */
    fun getFloatAsBehaviorSubject(key: String, defValue: Float): BehaviorSubject<Float> {
        if (mFloatPreferenceList[key] == null) {
            mFloatPreferenceList[key] = BehaviorSubject.create()
            mFloatPreferenceList[key]?.onNext(mSharedPreferenceManager.getFloat(key, defValue))
        }

        return mFloatPreferenceList[key]!!
    }

    /**
     *
     */
    fun getLongAsBehaviorSubject(key: String, defValue: Long): BehaviorSubject<Long> {
        if (mLongPreferenceList[key] == null) {
            mLongPreferenceList[key] = BehaviorSubject.create()
            mLongPreferenceList[key]?.onNext(mSharedPreferenceManager.getLong(key, defValue))
        }

        return mLongPreferenceList[key]!!
    }

    /**
     *
     */
    fun putBoolean(key: String, value: Boolean) {
        mBooleanPreferenceList[key] = mBooleanPreferenceList[key] ?: BehaviorSubject.create()
        mSharedPreferenceManager.edit().putBoolean(key, value).apply()

        mBooleanPreferenceList[key]?.onNext(value)
    }

    /**
     *
     */
    fun putString(key: String, value: String) {
        mStringPreferenceList[key] = mStringPreferenceList[key] ?: BehaviorSubject.create()
        mSharedPreferenceManager.edit().putString(key, value).apply()

        mStringPreferenceList[key]?.onNext(value)
    }

    /**
     *
     */
    fun putInt(key: String, value: Int) {
        mIntPreferenceList[key] = mIntPreferenceList[key] ?: BehaviorSubject.create()
        mSharedPreferenceManager.edit().putInt(key, value).apply()

        mIntPreferenceList[key]?.onNext(value)
    }

    /**
     *
     */
    fun putFloat(key: String, value: Float) {
        mFloatPreferenceList[key] = mFloatPreferenceList[key] ?: BehaviorSubject.create()
        mSharedPreferenceManager.edit().putFloat(key, value).apply()

        mFloatPreferenceList[key]?.onNext(value)
    }

    /**
     *
     */
    fun putLong(key: String, value: Long) {
        mLongPreferenceList[key] = mLongPreferenceList[key] ?: BehaviorSubject.create()
        mSharedPreferenceManager.edit().putLong(key, value).apply()

        mLongPreferenceList[key]?.onNext(value)
    }
}