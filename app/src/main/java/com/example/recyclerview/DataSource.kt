package com.example.recyclerview

import com.example.recyclerview.models.Moto

class DataSource {

    companion object {

        fun createDataSet() : ArrayList<Moto>{

            val list = ArrayList<Moto> ()
            list.add(
                Moto(
                    "YZF R1 - 2008",
                    "YAMAHA",
                    "https://www.moto.com.br/img/2008/09/29/img47393-1-1222713002-v1-450x299.jpg",
                    "https://www.youtube.com/watch?v=joTyWjA-nWY"
                )
            )

            list.add(
                Moto(
                    "CBR 1000 RR REPSOL - 2005",
                    "HONDA",
                    "https://i.ytimg.com/vi/KZjp1obKybo/maxresdefault.jpg",
                    "https://www.youtube.com/watch?v=KZjp1obKybo"
                )
            )
            list.add(
                Moto(
                    "HAYABUSA - GSX 1300 R 2011",
                    "SUZUKI",
                    "https://i.ytimg.com/vi/J3EI9ic3Tuc/maxresdefault.jpg",
                    "https://www.youtube.com/watch?v=J3EI9ic3Tuc"
                )
            )
            list.add(
                Moto(
                    "DAYTONA 675 - 2009",
                    "TRIUMPH",
                    "https://i.ytimg.com/vi/N63qX9Qa00w/maxresdefault.jpg",
                    "https://www.youtube.com/watch?v=N63qX9Qa00w"
                )
            )
            list.add(
                Moto(
                    "Z1000 - 2015",
                    "KAWASAKI",
                    "https://i.ytimg.com/vi/Qn426XqYg2g/maxresdefault.jpg",
                    "https://www.youtube.com/watch?v=F2mAcg_HzDA"
                )
            )
            return  list
        }
    }

}