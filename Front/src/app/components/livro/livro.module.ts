import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LivroRoutingModule } from './livro-routing.module';
import { LivroFormComponent } from './form/livro-form.component';
import { LivroListComponent } from './list/livro-list.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    LivroRoutingModule,
    FormsModule
  ],
  declarations: [LivroFormComponent, LivroListComponent]
})
export class LivroModule { }
