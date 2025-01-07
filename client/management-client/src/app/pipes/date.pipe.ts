import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'date'
})
export class DatePipe implements PipeTransform {

  transform(value: Date, ...args: unknown[]): string {
    return value.toDateString();
  }

}
