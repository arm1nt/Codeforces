//https://leetcode.com/problems/rotate-array/description/

fn main() {

    //remove following 2 lines
    let mut nums: Vec<i32> = vec![-1,-100,3,99];
    let k: i32 = 2;

    if nums.len() <= 1 {
        return;
    }


    let index: i32 = k % (nums.len() as i32);
    let numbers_after_start_element = (nums.len() as i32) - (index + 1);
    let numbers_of_beginning_elements = (nums.len() as i32) - (numbers_after_start_element+1);

    let mut result: Vec<i32> = Vec::new();

    let start_index_1: i32 = (nums.len() as i32) - numbers_of_beginning_elements;
    for index2 in start_index_1..(nums.len() as i32) {
        result.push(nums[index2 as usize]);
    }

    for index2 in 0..(numbers_after_start_element+1) {
        result.push(nums[index2 as usize]);
    }

    for index2 in 0..result.len() {
        nums[index2] = result[index2];
    }
}