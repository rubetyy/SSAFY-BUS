﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System.Runtime.InteropServices;

public class SelectItem : MonoBehaviour
{   
    
    [DllImport("__Internal")]
    private static extern void SendToItem(string item);

    public List<GameObject> FoundObjects;
    public float shortDis;
    public GameObject enemy;
    // Start is called before the first frame update

    void Start()
    {
        FoundObjects = new List<GameObject>(GameObject.FindGameObjectsWithTag("item"));
        enemy = FoundObjects[0]; // 첫번째를 먼저 
    }

    // Update is called once per frame
    void Update()
    {

        shortDis = Vector3.Distance(gameObject.transform.position, enemy.transform.position); // 첫번째를 기준으로 잡아주기 
        cakeslice.Outline outline = enemy.GetComponent<cakeslice.Outline>();
        outline.eraseRenderer = true;
 
 
        foreach (GameObject found in FoundObjects)
        {
            float Distance = Vector3.Distance(gameObject.transform.position, found.transform.position);
 
            if (Distance < shortDis) // 위에서 잡은 기준으로 거리 재기
            {
                enemy = found;
                shortDis = Distance;
            }
        }

        outline = enemy.GetComponent<cakeslice.Outline>();
        float limit = 3.0f;
        if(shortDis < limit) {
            outline.eraseRenderer = false;
            if(Input.GetKey(KeyCode.LeftShift)){
                if(enemy.name == "check"){
                    Application.OpenURL("https://edu.ssafy.com/comm/login/SecurityLoginForm.do");
                }
                else if(enemy.name == "ebook"){
                    Application.OpenURL("https://ssafy2.dkyobobook.co.kr/main.ink");
                }
                else if(enemy.name == "Board"){
                    Application.OpenURL("https://edu.ssafy.com/edu/board/free/list.do?searchBrdItmCdVal=4");
                }
                else {
                string itemName = enemy.name;
                SendToItem(itemName);
                }
            }
        }
        else{
            outline.eraseRenderer = true;
        }
    }
}
