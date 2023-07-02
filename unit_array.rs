//https://codeforces.com/problemset/problem/1834/A

fn main() {

    let mut number_of_inputs = get_number();

    while number_of_inputs != 0 {
        let _array_size = get_number();
        let vec = read_line();

        println!("{}", good_array(&vec));
        
        number_of_inputs-=1;
    }
}

fn good_array(vec: &Vec<i32>) -> u64 {
    let mut count_positives: u64 = 0;
    let mut count_negatives: u64 = 0;

    for el in vec {
        if *el == 1 {
            count_positives +=1;
        } else {
            count_negatives += 1;
        }
    }

    let min_half = if vec.len()%2 == 0 {(vec.len()/2) as u64} else {((vec.len()/2) + 1) as u64};

    if count_positives >= min_half {
        return count_negatives % 2;
    }

    let still_needed = min_half - count_positives;
    if (count_negatives - still_needed) % 2 == 0 {
        return still_needed;
    } else {
        return still_needed+1;
    }
}

fn get_number() -> i32 {
    use std::io::{stdin};

    let mut input = String::new();

    stdin()
        .read_line(&mut input)
        .expect("Error reading input");

    let number: i32 = input.trim().parse().unwrap();
    return number;
}

fn read_line() -> Vec<i32> {
    use std::io::{stdin};

    let mut input = String::new();

    stdin()
        .read_line(&mut input)
        .expect("Error reading input");

    let inputs:Vec<i32> = input.split(" ").map(|x| x.trim().parse().expect("Not an integer")).collect();
    return inputs;
}