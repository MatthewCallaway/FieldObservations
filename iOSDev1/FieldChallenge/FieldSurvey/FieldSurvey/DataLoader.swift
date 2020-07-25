//
//  DataLoader.swift
//  FieldSurvey
//
//  Created by Matthew Callaway on 7/24/20.
//  Copyright © 2020 Matthew Callaway. All rights reserved.
//

import Foundation

public class DataLoader{
    @Published var observationData = [ObservationData]()
    var i = 0;
    init(){
        load()
    }
    
    func load(){
        do{
        if let url = Bundle.main.url(forResource:"field_observations", withExtension: "json") {
                let data = try Data(contentsOf: url)
                //let jsonDecoder =  JSONDecoder()
                let dataFromJson = try JSONSerialization.jsonObject(with: data, options: [])
                
                if let object = dataFromJson as? [String: Any]{
                    print(object)
                  //  print("hello")
                }else if let object = dataFromJson as? [Any]{
                    for anItem in object as! [Dictionary<String, AnyObject>] {
                        let newTitle = anItem["title"] as! String
                        let newClass = anItem["classification"] as! String
                        let newDesc = anItem["description"] as! String
                        let newDate = anItem["date"] as! Date
                        let observation = ObservationData(classification:newClass, title: newTitle, description: newDesc, date: newDate)
                        print(observation)
                        observationData[i] = observation
                        //observationData[i].getString()
                        i = i+1
                    }
                    //print(observationData[1].getString())
                }else{
                    print("JSON is invalid")
                }
            }else{
            print("No File")
            }
                //self.observationData = dataFromJson
                
            }catch{
                print("error in json url statement")
            }
        }
    }




