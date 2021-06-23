import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class CadastroService {

    urlBase = environment.urlBase;

    constructor(private http: HttpClient) { }

    consultarListaCarros(): Promise<any> {

        return this.http.get(this.urlBase + '/carros')
            .toPromise()
            // .then(response => {console.log("response", response)});
            .then(response => {return response});
    }

}
