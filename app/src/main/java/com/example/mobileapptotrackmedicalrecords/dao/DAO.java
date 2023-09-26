package com.example.mobileapptotrackmedicalrecords.dao;

import com.google.firebase.database.DatabaseReference;

import com.google.firebase.storage.StorageReference;

public class DAO
{
    public static DatabaseReference getDBReference(String dbName)
    {
        return GetFireBaseConnection.getConnection(dbName);
    }

    public static StorageReference getStorageReference() {
        return GetFireBaseConnection.getStorageReference();
    }

    public static String getUnicKey(String dbName)
    {
        return getDBReference(dbName).push().getKey();
    }

    public int addObject(String dbName,Object obj,String key) {

        int result=0;

        try {

            getDBReference(dbName).child(key).setValue(obj);

            result=1;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return result;
    }

    public int deleteObject(String dbName, String key) {

        int result=0;

        try {

            getDBReference(dbName).child(key).removeValue();

            result=1;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return 0;
    }
}


