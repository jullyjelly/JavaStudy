String.prototype.trim = function () {
    var start, end;
    start = 0;
    end = this.length - 1;
    while(start<end && this.charAt(start)==" "){
        start++;
    }
    while(start<end && this.charAt(end)==" "){
        end--;
    }
    return this.substring(start,end+1);
}