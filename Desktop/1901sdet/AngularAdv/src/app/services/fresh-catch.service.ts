import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { entree } from '../models/entree';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FreshCatchService {

  constructor(private http:HttpClient) { }

  getRecentCatches():Observable<entree>{

    return this.http.get<entree>("https://api.myjson.com/bins/18hvhi");    

  };




}
