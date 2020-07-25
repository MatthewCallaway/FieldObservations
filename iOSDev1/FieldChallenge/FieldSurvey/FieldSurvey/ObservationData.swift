//
//  ObservationData.swift
//  FieldSurvey
//
//  Created by Matthew Callaway on 7/24/20.
//  Copyright © 2020 Matthew Callaway. All rights reserved.
//

import Foundation


struct ObservationData: Codable{
    var classification: String
    var title: String
    var description: String
    var date: Date
    func getString() {
        print( "is this working")
    }
}
